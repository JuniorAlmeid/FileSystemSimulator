# Simulador de Sistema de Arquivos com Journaling em Java

---

## Metodologia

O simulador foi desenvolvido em linguagem de programação **Java**. Ele recebe comandos no formato texto, interpretando-os e executando operações similares às de um sistema operacional em um sistema de arquivos virtual. Cada comando corresponde a um método que manipula arquivos e diretórios, além de registrar as operações no journal (log) para rastreamento.

O programa executa as funcionalidades solicitadas e exibe o resultado na interface gráfica Swing, facilitando a interação do usuário.

---

## Parte 1: Introdução ao Sistema de Arquivos com Journaling

### O que é um sistema de arquivos?

Um sistema de arquivos é a estrutura responsável por armazenar e organizar dados em dispositivos de armazenamento, permitindo criar, modificar, mover e deletar arquivos e diretórios. Ele é essencial para o funcionamento de qualquer sistema operacional, garantindo que a informação seja gerenciada de forma eficiente e segura.

### Importância do Journaling

O **journaling** é uma técnica usada em sistemas de arquivos para melhorar a confiabilidade e a integridade dos dados. Ele consiste em manter um registro (log) das operações antes de executá-las, para garantir que, em caso de falha (como queda de energia ou travamento), o sistema possa recuperar seu estado consistente.

Existem diferentes tipos de journaling, como:

- **Write-Ahead Logging:** As operações são registradas no journal antes de serem aplicadas.
- **Log-Structured File Systems:** O sistema escreve diretamente em um log sequencial.

Nosso simulador utiliza um mecanismo simplificado de journaling para registrar as operações feitas no sistema de arquivos virtual.

---

## Parte 2: Arquitetura do Simulador

### Estrutura de Dados

O sistema de arquivos virtual é representado por três principais classes:

- **VirtualFile:** Representa um arquivo, com nome e conteúdo.
- **VirtualDirectory:** Representa um diretório, que pode conter arquivos e outros diretórios (subdiretórios).
- **FileSystemSimulator:** Gerencia a navegação entre diretórios e executa comandos, mantendo a referência para o diretório atual.

### Journaling

A classe **Journal** mantém uma lista de registros (logs) das operações executadas, como criação, exclusão, renomeação, e cópia de arquivos e diretórios. Cada operação relevante é registrada, permitindo que o usuário visualize o histórico de ações.

---

## Parte 3: Implementação em Java

### Principais classes:

- **FileSystemSimulator**: 
  - Interpreta comandos como `mkdir`, `rmdir`, `touch`, `rm`, `rename`, `copy`, `cd`, `ls`, `pwd` e `log`.
  - Atualiza o estado do sistema e registra as ações no journal.

- **VirtualDirectory**: 
  - Gerencia diretórios e seus conteúdos (arquivos e subdiretórios).
  - Implementa criação, remoção, renomeação e listagem.

- **VirtualFile**: 
  - Representa arquivos virtuais, permitindo armazenar conteúdo (embora a manipulação de conteúdo não esteja no escopo atual).

- **Journal**: 
  - Armazena e retorna o histórico das operações para auditoria.

### Interface Gráfica (GUI)

Utiliza Swing para criar uma interface simples, com:

- Área de texto para mostrar resultados e logs.
- Campo de texto para entrada dos comandos.
- Botão para executar comandos.

---

## Parte 4: Instalação e Funcionamento

### Requisitos

- Java JDK 8 ou superior
- IDE recomendada: IntelliJ IDEA, Eclipse ou VS Code com extensão Java
- Sistema operacional: Windows, Linux ou macOS

### Passos para executar o simulador

1. Clone este repositório:
   ```bash
   git clone <URL-do-repositorio>
