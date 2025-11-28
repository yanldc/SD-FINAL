@echo off
echo Iniciando multiplas instancias dos microservicos...

echo.
echo === Iniciando Eureka Server ===
start "Eureka Server" cmd /k "cd ms-eureka-server && gradlew bootRun"

timeout /t 10

echo.
echo === Iniciando MS-Clientes - Instancia 1 (porta 8080) ===
start "MS-Clientes-1" cmd /k "cd ms-clientes && gradlew bootRun"

echo.
echo === Iniciando MS-Clientes - Instancia 2 (porta 8090) ===
start "MS-Clientes-2" cmd /k "cd ms-clientes && gradlew bootRun --args='--server.port=8090'"

timeout /t 5

echo.
echo === Iniciando MS-Veiculos - Instancia 1 (porta 8081) ===
start "MS-Veiculos-1" cmd /k "cd ms-veiculos && gradlew bootRun"

echo.
echo === Iniciando MS-Veiculos - Instancia 2 (porta 8091) ===
start "MS-Veiculos-2" cmd /k "cd ms-veiculos && gradlew bootRun --args='--server.port=8091'"

timeout /t 5

echo.
echo === Iniciando MS-Aluguel (porta 8083) ===
start "MS-Aluguel" cmd /k "cd ms-aluguel && gradlew bootRun"

echo.
echo Todos os microservicos foram iniciados!
echo Eureka Dashboard: http://localhost:8761
echo.
pause