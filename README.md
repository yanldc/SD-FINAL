# Sistema de Locadora de Veículos - Microserviços

Sistema distribuído para gerenciamento de locadora de veículos com 4 microserviços:
- **Eureka Server** (Service Discovery)
- **MS Clientes** (Gerenciamento de clientes)
- **MS Veículos** (Gerenciamento de veículos)
- **MS Aluguel** (Gerenciamento de aluguéis)

## 🚀 Como Executar

### 1. Configurar MySQL
**IMPORTANTE:** Crie os bancos de dados no MySQL:
```sql
CREATE DATABASE locadora_clientes;
CREATE DATABASE locadora_veiculos;
CREATE DATABASE locadora_aluguel;
```

### 2. Executar os Microserviços

**Opção 1: Execução Automática (Recomendado)**
```bash
# No PowerShell
.\start-multiple-instances.bat
```

**Opção 2: Execução Manual**
Execute nesta ordem em terminais separados:

```bash
# 1. Eureka Server (aguarde inicializar)
cd ms-eureka-server
./gradlew bootRun

# 2. Clientes
cd ms-clientes
./gradlew bootRun

# 3. Veículos
cd ms-veiculos
./gradlew bootRun

# 4. Aluguel
cd ms-aluguel
./gradlew bootRun
```

### 3. Verificar
- **Eureka Dashboard:** http://localhost:8761
- **Clientes:** http://localhost:8080/clientes
- **Veículos:** http://localhost:8081/veiculos
- **Aluguéis:** http://localhost:8083/alugueis

## 🧪 Testes com Postman

1. Abra o Postman
2. Clique em **Import**
3. Selecione o arquivo: **`Locadora_Microservices.postman_collection.json`**
4. Execute os requests na ordem da collection

## 📊 Dados Automáticos

O sistema cria automaticamente:
- 2 clientes de exemplo
- 2 veículos de exemplo
- 2 aluguéis de exemplo
- Status de aluguéis (ATIVO, FINALIZADO)

## 🔧 Funcionalidades

- **Validações:** CNH única, placa única, idade ≥ 18 anos
- **Relacionamentos:** Aluguel ↔ Status (tabelas relacionadas)
- **Múltiplas instâncias:** Suporte a load balancing
- **Tratamento de erros:** Exception handlers globais