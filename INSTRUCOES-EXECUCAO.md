# Como Executar Múltiplas Instâncias

## 1. Abra 6 terminais separados

## 2. Execute em cada terminal (nesta ordem):

### Terminal 1 - Eureka Server
```bash
cd ms-eureka-server
gradlew bootRun
```

### Terminal 2 - MS-Clientes Instância 1
```bash
cd ms-clientes
gradlew bootRun
```

### Terminal 3 - MS-Clientes Instância 2
```bash
cd ms-clientes
gradlew bootRun --args="--server.port=8090"
```

### Terminal 4 - MS-Veículos Instância 1
```bash
cd ms-veiculos
gradlew bootRun
```

### Terminal 5 - MS-Veículos Instância 2
```bash
cd ms-veiculos
gradlew bootRun --args="--server.port=8091"
```

### Terminal 6 - MS-Aluguel
```bash
cd ms-aluguel
gradlew bootRun
```

## 3. Verificar no Eureka
- Acesse: http://localhost:8761
- Deve mostrar 5 instâncias registradas

## URLs dos Serviços:
- Clientes-1: http://localhost:8080/clientes
- Clientes-2: http://localhost:8090/clientes
- Veículos-1: http://localhost:8081/veiculos
- Veículos-2: http://localhost:8091/veiculos
- Aluguel: http://localhost:8083/alugueis