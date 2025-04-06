# Projeto Integrador V-B Módulo Java.

Este módulo Java simula a coleta de dados de sensores de luminosidade, temperatura e umidade, com a possibilidade de se comunicar via uma porta serial (como no caso de um Arduino). O código simula a coleta de dados, analisa as informações obtidas e fornece feedback sobre as condições do ambiente, como a luminosidade, temperatura e umidade.

## Funcionalidades

- **Busca de Porta Serial**: O programa começa identificando as portas seriais disponíveis no sistema e tenta conectar-se à primeira encontrada.
- **Simulação de Leitura de Dados dos Sensores**: Os dados dos sensores (luminosidade, temperatura e umidade) são gerados aleatoriamente para simulação, imitando o comportamento de um Arduino conectado ao computador.
- **Processamento de Dados**: Após a coleta, os dados simulados são analisados para fornecer um feedback sobre as condições do ambiente:
  - **Luminosidade**: O programa verifica se o ambiente está muito escuro, muito claro ou com luminosidade adequada.
  - **Temperatura**: O programa determina se o ambiente está frio, quente ou confortável.
  - **Umidade**: O programa analisa se o ambiente está seco, muito úmido ou com umidade adequada.
- **Comunicação Serial**: O código simula a interação com a porta serial do Arduino (ou outro dispositivo) através da biblioteca `jSerialComm`.

## Estrutura do Código

### 1. SensorData (Classe Interna)
Representa os dados de um sensor com três parâmetros: luminosidade, temperatura e umidade. O método `toString()` é sobrescrito para exibir esses dados de forma legível.

### 2. Método `buscarPortaArduino()`
Lista todas as portas seriais disponíveis e retorna a primeira porta que encontra. Se nenhuma porta for encontrada, retorna `null`.

### 3. Método `lerDadosDosSensores()`
Simula a leitura de dados de sensores, gerando valores aleatórios dentro de intervalos representativos (luminosidade entre 0 e 100, temperatura entre -10°C e 30°C, umidade entre 0 e 100).

### 4. Método `processarDados(SensorData dados)`
Processa os dados simulados dos sensores e fornece feedback sobre as condições do ambiente com base em limites definidos (luminosidade, temperatura e umidade).

## Requisitos

- **Biblioteca `jSerialComm`**: Para utilizar a comunicação serial, você precisará da biblioteca `jSerialComm`. Certifique-se de adicionar essa dependência ao seu projeto.
- **JDK**: A aplicação foi desenvolvida com Java, portanto, é necessário ter o JDK instalado para compilar e executar o código.
