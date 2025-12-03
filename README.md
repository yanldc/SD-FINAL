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

### 2. Executar Sistema Distribuído

**Opção 1: Execução Automática (Recomendado)**
```bash
# Inicia todas as instâncias automaticamente
.\start-all-instances.bat
```

**Opção 2: Execução Manual**
Abra 6 terminais e execute nesta ordem:

```bash
# Terminal 1 - Eureka Server
cd ms-eureka-server
gradlew bootRun

# Terminal 2 - Clientes Instância 1
cd ms-clientes
gradlew bootRun

# Terminal 3 - Clientes Instância 2
cd ms-clientes
gradlew bootRun --args="--server.port=8090"

# Terminal 4 - Veículos Instância 1
cd ms-veiculos
gradlew bootRun

# Terminal 5 - Veículos Instância 2
cd ms-veiculos
gradlew bootRun --args="--server.port=8091"

# Terminal 6 - Aluguel
cd ms-aluguel
gradlew bootRun
```

### 3. Verificar Sistema Distribuído
- **Eureka Dashboard:** http://localhost:8761 (deve mostrar 5 instâncias)
- **Clientes Inst1:** http://localhost:8080/clientes
- **Clientes Inst2:** http://localhost:8090/clientes
- **Veículos Inst1:** http://localhost:8081/veiculos
- **Veículos Inst2:** http://localhost:8091/veiculos
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

### Sistema Distribuído
- **Múltiplas instâncias:** 2 instâncias de MS-Clientes e MS-Veículos
- **Load Balancing:** Distribuição automática via Eureka
- **Service Discovery:** Registro automático de serviços
- **Tolerância a falhas:** Redundância de instâncias

### Recursos Técnicos
- **Validações:** CNH única, placa única, idade ≥ 18 anos
- **Relacionamentos:** Aluguel ↔ Status (tabelas relacionadas)
- **DTOs organizados:** Estrutura separada por pasta
- **Tratamento de erros:** Exception handlers globais