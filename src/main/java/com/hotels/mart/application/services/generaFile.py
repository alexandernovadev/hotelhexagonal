import os

def rename_and_replace_in_files(old_name, new_name, old_directory, new_directory):
    # Convertir los nombres a minúsculas para el contenido de los archivos
    old_name_lower = old_name.lower()
    new_name_lower = new_name.lower()

    # Crear el nuevo directorio si no existe
    if not os.path.exists(new_directory):
        os.makedirs(new_directory)

    # Iterar sobre los archivos en el directorio actual que contienen el viejo nombre
    for filename in os.listdir(old_directory):
        if old_name in filename or old_name_lower in filename:
            # Crear el nuevo nombre de archivo reemplazando old_name con new_name
            new_filename = filename.replace(old_name, new_name).replace(old_name_lower, new_name_lower)

            # Leer el contenido del archivo viejo y reemplazar las palabras clave
            with open(os.path.join(old_directory, filename), 'r') as file:
                content = file.read()
                content = content.replace(old_name, new_name).replace(old_name_lower, new_name_lower)

            # Escribir el contenido actualizado al nuevo archivo en el nuevo directorio
            with open(os.path.join(new_directory, new_filename), 'w') as file:
                file.write(content)

# Definir el directorio viejo y el nuevo
old_dir = './sex'
new_dir = './userstate'

# Llamar a la función para hacer el cambio
rename_and_replace_in_files('Sex', 'UserState', old_dir, new_dir)
