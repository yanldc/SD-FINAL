@echo off
echo ========================================
echo  EXECUTAR MANUALMENTE EM 6 TERMINAIS
echo ========================================
echo.
echo 1. Eureka Server:
echo    cd ms-eureka-server
echo    gradlew bootRun
echo.
echo 2. MS-Clientes Inst1:
echo    cd ms-clientes
echo    gradlew bootRun
echo.
echo 3. MS-Clientes Inst2:
echo    cd ms-clientes
echo    gradlew bootRun --args="--server.port=8090"
echo.
echo 4. MS-Veiculos Inst1:
echo    cd ms-veiculos
echo    gradlew bootRun
echo.
echo 5. MS-Veiculos Inst2:
echo    cd ms-veiculos
echo    gradlew bootRun --args="--server.port=8091"
echo.
echo 6. MS-Aluguel:
echo    cd ms-aluguel
echo    gradlew bootRun
echo.
echo Verifique: http://localhost:8761
echo.
pause