
# Taller 3: Verbos HTTP

Una API RESTful donde utilicé diferentes métodos HTTP (verbos) para realizar diferentes acciones

## URL

Corriendo en:

```bash
  http://localhost:8080
```
### GET
Sirve para obtener datos del servidor, como páginas web o recursos.

```http
  GET /songs/getSongs
```

### POST
Sirve para enviar datos al servidor, como formularios o datos de carga.
```http
  POST /songs/createSong
  {
    "title": "Como tiene que ser",
    "artist": "Arcángel la",
    "album": "Sentimiento Elegancia & Maldad",
    "genre": "Reggaeton"
  }
```

### PUT
Sirve para reemplazar o crear un recurso específico en el servidor.

```http
  PUT /songs/updateSong
  {
    "id": "661c71bb02cf19093493da58",
    "title": "Como tiene que ser",
    "artist": "Arcángel la maravilla",
    "album": "Sentimiento Elegancia & Maldad",
    "genre": "Reggaeton"
  }
```


### DELETE
Sirve para eliminar un recurso específico en el servidor.

```http
 DELETE /songs/deleteSong/661c71bb02cf19093493da58
```

### PATCH
Sirve para modificar parcialmente un recurso en el servidor.

```http
 PATCH /songs/patchSong/661c6f9d02cf19093493da58
 {
    "title": "Como tiene que ser"
  }
```

### HEAD
Sirve para obtener solo los encabezados de respuesta, esto es útil para verificar la disponibilidad de recursos sin descargar todo el contenido.

```http
 HEAD /songs/headerSong/661c6f9d02cf19093493da54
```

### OPTIONS
Sirve Para solicitar los métodos HTTP permitidos por el servidor para un recurso específico.

```http
 OPTIONS /songs/optionsSong
```
