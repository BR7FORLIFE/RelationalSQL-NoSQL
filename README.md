# 🧠 Database Systems: Architecture, Theory & Practice

Este repositorio es un **estudio profundo y estructurado de los Sistemas de Gestión de Bases de Datos (DBMS)**, enfocado en **arquitectura, teoría, infraestructura y decisiones de diseño**, más allá del uso superficial de lenguajes o frameworks.

El objetivo no es aprender *cómo usar* una base de datos, sino **entender cómo funciona realmente**, qué problemas fundamentales resuelve y qué trade-offs existen entre distintos motores como **PostgreSQL** y **MongoDB**.

---

## 🎯 Objetivo del repositorio

Este repositorio busca desarrollar criterio técnico para:

- Diseñar modelos de datos correctos según el dominio
- Entender concurrencia, consistencia y fallos
- Analizar decisiones arquitectónicas internas
- Elegir la base de datos adecuada según el problema
- Comprender infraestructura, no solo APIs

---

## 🚫 Qué NO es este repositorio

Este repositorio **NO** es:
- un tutorial de SQL o MongoDB
- una colección de CRUDs
- una guía de frameworks u ORMs
- una abstracción simplificada del funcionamiento interno

---

## ✅ Qué SÍ es este repositorio

Este repositorio **SÍ** es:
- un estudio de **arquitectura interna de DBMS**
- una exploración de **teoría de bases de datos**
- un análisis comparativo entre modelos relacionales y documentales
- un enfoque orientado a **ingeniería y sistemas**

---

## 🏗️ Arquitectura de un DBMS moderno

El estudio se estructura siguiendo la arquitectura interna de una base de datos moderna, desde la interfaz de cliente hasta el hardware subyacente.

### 🌳 Árbol de arquitectura (referencia central)

```js

BASE DE DATOS (DBMS) 
│ 
├── 1. Client Interface 
│   ├── Drivers (JDBC, ODBC, Mongo Driver, etc) 
│   ├── Protocolos (TCP, TLS) 
│   └── Autenticación inicial 
│ 
├── 2. Query Layer 
│   ├── Parser 
│   │   ├── Lexical analysis 
│   │   └── Syntax tree (AST) 
│   │ 
│   ├── Validator 
│   │   ├── Schema validation 
│   │   ├── Permissions 
│   │   └── Type checking 
│   │ 
│   ├── Query Optimizer 
│   │   ├── Cost-based optimizer 
│   │   ├── Statistics 
│   │   ├── Index selection 
│   │   └── Execution plan 
│   │ 
│   └── Execution Engine 
│       ├── Operators (scan, join, filter) 
│       ├── Pipeline execution 
│       └── Result materialization 
│ 
├── 3. Transaction Manager 
│   ├── Transaction lifecycle 
│   │   ├── BEGIN 
│   │   ├── COMMIT 
│   │   └── ROLLBACK 
│   │ 
│   ├── Isolation control 
│   │   ├── MVCC 
│   │   ├── Locks 
│   │   └── Snapshots 
│   │ 
│   └── Concurrency control 
│       ├── Deadlock detection 
│       └── Conflict resolution 
│ 
├── 4. Storage Engine 
│   ├── Data organization 
│   │   ├── Pages / Blocks 
│   │   ├── Segments 
│   │   └── Tablespaces / Collections 
│   │ 
│   ├── Index Manager 
│   │   ├── B-Tree 
│   │   ├── Hash indexes 
│   │   ├── LSM Trees 
│   │   └── Compound / Partial indexes 
│   │ 
│   ├── Buffer Manager 
│   │   ├── Cache pages in memory 
│   │   ├── Eviction policy 
│   │   └── Dirty page tracking 
│   │ 
│   └── Free space manager 
│ 
├── 5. Durability & Recovery 
│   ├── Write-Ahead Log (WAL / Journal) 
│   ├── Checkpoints 
│   ├── Crash recovery 
│   └── Backup & Restore 
│ 
├── 6. Replication & Distribution 
│   ├── Replication 
│   │   ├── Leader / Follower 
│   │   ├── Sync / Async 
│   │   └── Log shipping 
│   │ 
│   ├── Consensus 
│   │   ├── Raft / Paxos 
│   │   └── Leader election 
│   │ 
│   ├── Sharding / Partitioning 
│   │   ├── Range-based 
│   │   ├── Hash-based 
│   │   └── Zone-based 
│   │ 
│   └── Failover 
│ 
├── 7. Security Layer 
│   ├── Authentication 
│   ├── Authorization (RBAC) 
│   ├── Encryption at rest 
│   └── Encryption in transit 
│ 
├── 8. Observability & Maintenance 
│   ├── Metrics 
│   ├── Logs 
│   ├── Query statistics 
│   ├── Vacuum / Compaction 
│   └── Auto-tuning 
│ 
└── 9. Hardware / OS Layer 
    ├── CPU 
    ├── RAM 
    ├── Disk (SSD / HDD / NVMe) 
    ├── Filesystem 
    └── Network 

```


---

## 🧩 Bases de datos estudiadas

### PostgreSQL
- Modelo relacional
- Consistencia fuerte (ACID)
- MVCC y optimización avanzada
- Ideal para dominios transaccionales

### MongoDB
- Modelo documental
- Escalabilidad horizontal
- Alta disponibilidad
- Diseño basado en agregados y desnormalización

Ambas se estudian **de forma comparativa**, entendiendo que resuelven **problemas distintos**.

---

## 🧠 Enfoque de aprendizaje

El aprendizaje se basa en:
- teoría primero, implementación después
- entender *por qué* antes que *cómo*
- justificar cada decisión de diseño
- analizar impactos de infraestructura

---

## 📚 Referencias clave

- *Designing Data-Intensive Applications* – Martin Kleppmann  
- *Database Internals* – Alex Petrov  
- Documentación oficial de PostgreSQL y MongoDB  

---

## 🧠 Nota final

> *Una base de datos no es un contenedor de datos,  
> es un sistema que gobierna la verdad bajo concurrencia y fallos.*

Este repositorio refleja esa filosofía.
