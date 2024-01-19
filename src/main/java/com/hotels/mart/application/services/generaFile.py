import os

def rename_and_replace_in_files(old_name, new_name, directory):
    # Convertir los nombres a minúsculas para el contenido de los archivos
    old_name_lower = old_name.lower()
    new_name_lower = new_name.lower()
    
    # Iterar sobre los archivos en el directorio actual que contienen el viejo nombre
    for filename in os.listdir(directory):
        if old_name in filename or old_name_lower in filename:
            # Crear el nuevo nombre de archivo reemplazando old_name con new_name
            new_filename = filename.replace(old_name, new_name).replace(old_name_lower, new_name_lower)
            
            # Leer el contenido del archivo viejo y reemplazar las palabras clave
            with open(os.path.join(directory, filename), 'r') as file:
                content = file.read()
                content = content.replace(old_name, new_name).replace(old_name_lower, new_name_lower)

            # Escribir el contenido actualizado al nuevo archivo
            with open(os.path.join(directory, new_filename), 'w') as file:
                file.write(content)
            
            # Opcional: Eliminar el archivo viejo si es necesario
            # os.remove(os.path.join(directory, filename))

# Llamar a la función desde el directorio 'services'
rename_and_replace_in_files('Sex', 'Book', './sex')
