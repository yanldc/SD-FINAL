@echo off
echo ========================================
echo  INICIANDO SISTEMA DISTRIBUIDO
echo ========================================

echo.
echo [1/6] Eureka Server (8761)...
start "Eureka-Server" cmd /c "cd /d %~dp0ms-eureka-server && gradlew bootRun"

timeout /t 20

echo.
echo [2/6] MS-Clientes Instancia 1 (8080)...
start "Clientes-8080" cmd /c "cd /d %~dp0ms-clientes && gradlew bootRun"

timeout /t 15

echo.
echo [3/6] MS-Clientes Instancia 2 (8090)...
start "Clientes-8090" cmd /c "cd /d %~dp0ms-clientes && gradlew bootRun --args=--server.port=8090"

timeout /t 15

echo.
echo [4/6] MS-Veiculos Instancia 1 (8081)...
start "Veiculos-8081" cmd /c "cd /d %~dp0ms-veiculos && gradlew bootRun"

timeout /t 15

echo.
echo [5/6] MS-Veiculos Instancia 2 (8091)...
start "Veiculos-8091" cmd /c "cd /d %~dp0ms-veiculos && gradlew bootRun --args=--server.port=8091"

timeout /t 15

echo.
echo [6/6] MS-Aluguel (8083)...
start "Aluguel-8083" cmd /c "cd /d %~dp0ms-aluguel && gradlew bootRun"

echo.
echo ========================================
echo  TODAS AS INSTANCIAS FORAM INICIADAS!
echo ========================================
echo.
echo Aguarde alguns minutos para inicializacao completa
echo Verifique o Eureka: http://localhost:8761
echo.
echo INSTANCIAS ATIVAS:
echo - MS-Clientes: 2 instancias (8080, 8090)
echo - MS-Veiculos: 2 instancias (8081, 8091)
echo - MS-Aluguel: 1 instancia (8083)
echo.
pause