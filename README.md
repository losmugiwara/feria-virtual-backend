<h1>Spring Boot</h1>
<h2>JWT authentication api / Spring Security</h2>
<br>

<h3>Instrucciones para registro de usuarios:</h3>
<hr>
<h5><strong>Adminisitrador:</strong></h5>

<pre>
{
    "userName": "admin",
    "email": "admin@admin.com",
    "password": "admin",
    "roles": ["admin"]
}
</pre>

<h5><strong>Usuario por defecto:</strong></h5>

<pre>
{
    "userName": "john",
    "email": "john@doe.com",
    "password": "johndoe"
}
</pre>


<h3>Instrucciones para crear un producto:</h3>
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


