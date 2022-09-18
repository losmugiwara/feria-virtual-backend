<h1>Spring Boot</h1>
<h2>JWT authentication api / Spring Security</h2>

<h2>Configuración de Oracle 11g con contenedor de Docker</h2>

<a href="https://github.com/jonathanpereiram/Spring-Boot-OracleDB.git">Ir a configuración</a>

<h3>Instrucciones para registro de usuarios:</h3>
<hr>
<h5><strong>Adminisitrador:</strong></h5>

<pre>
{
    "userName": "admin",
    "email": "admin@admin.com",
    "password": "admin",
    "name": "admin",
    "lastName": "admin",
    "roles": ["admin"]
}
</pre>

<h5><strong>Cliente externo:</strong></h5>

<pre>
{
    "userName": "john",
    "email": "john@doe.com",
    "password": "johndoe",
    "name": "john",
    "lastName": "Doe",
    "roles": ["ROLE_CUSTOMER_EXTERNAL"]
}
</pre>

<h5><strong>Cliente interno:</strong></h5>

<pre>
{
    "userName": "john",
    "email": "john@doe.com",
    "password": "johndoe",
    "name": "john",
    "lastName": "Doe",
    "roles": ["ROLE_CUSTOMER_INTERNAL"]
}
</pre>


<h3>Instrucciones crear nuestros objetos desde un cliente:</h3>
<hr>
<h5><strong>Producto:</strong></h5>

<pre>
{
    "nameProduct": "Naranja",
    "stock": 4,
    "category": {
        "id": 1,
        "nameCategory": "Frutas"
    }
}
</pre>

<h5><strong>Categoria:</strong></h5>

<pre>
{
    "nameCategory": "Frutas"
}
</pre>


