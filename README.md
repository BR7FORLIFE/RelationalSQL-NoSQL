# RelationalSQL-NoSQL

# 📚 SQL Sub-lenguajes

SQL no es un lenguaje único, sino que se divide en **sub-lenguajes** según el tipo de operaciones que realices sobre la base de datos.

---

## 🔹 1. DDL → *Data Definition Language* (Lenguaje de Definición de Datos)

Sirve para **definir y modificar la estructura** de la base de datos.

Ejemplos:

```sql
CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL
);

ALTER TABLE usuario ADD COLUMN edad INT;
DROP TABLE usuario;
```

Palabras clave: `CREATE`, `ALTER`, `DROP`, `TRUNCATE`.

---

## 🔹 2. DML → *Data Manipulation Language* (Lenguaje de Manipulación de Datos)

Sirve para **insertar, modificar y borrar registros** (CRUD).

Ejemplos:

```sql
INSERT INTO usuario(username, email, role)
VALUES ('ana123', 'ana@mail.com', 'ADMIN');

UPDATE usuario SET role = 'SUPERADMIN' WHERE id = 1;

DELETE FROM usuario WHERE id = 2;
```

Palabras clave: `INSERT`, `UPDATE`, `DELETE`.

---

## 🔹 3. DQL → *Data Query Language* (Lenguaje de Consulta de Datos)

Sirve para **consultar (leer)** datos.

Ejemplos:

```sql
SELECT * FROM usuario;

SELECT username, email
FROM usuario
WHERE role = 'ADMIN'
ORDER BY username ASC;

SELECT role, COUNT(*)
FROM usuario
GROUP BY role;
```

Palabras clave: `SELECT`.

---

## 🔹 4. DCL → *Data Control Language* (Lenguaje de Control de Datos)

Sirve para **gestionar permisos y roles de usuarios**.

Ejemplos:

```sql
GRANT SELECT, INSERT ON usuario TO app_user;
REVOKE INSERT ON usuario FROM app_user;
```

Palabras clave: `GRANT`, `REVOKE`.

---

## 🔹 5. TCL → *Transaction Control Language* (Lenguaje de Control de Transacciones)

Sirve para **manejar transacciones** y garantizar propiedades **ACID**.

Ejemplos:

```sql
BEGIN;
UPDATE cuenta SET saldo = saldo - 100 WHERE id = 1;
UPDATE cuenta SET saldo = saldo + 100 WHERE id = 2;
COMMIT;   -- guarda los cambios
-- ROLLBACK; -- deshace si hubo error
```

Palabras clave: `BEGIN`, `COMMIT`, `ROLLBACK`, `SAVEPOINT`.

---

# 📌 Resumen rápido

* **DDL** → Estructura (tablas, columnas, constraints).
* **DML** → CRUD (insertar, actualizar, eliminar).
* **DQL** → Consultar (SELECT).
* **DCL** → Permisos (GRANT, REVOKE).
* **TCL** → Transacciones (BEGIN, COMMIT, ROLLBACK).
