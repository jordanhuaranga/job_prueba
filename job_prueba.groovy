pipeline {
    agent any
    
    environment {
        nombre_servidor = "DESKTOP-8ONKPR4"
        usuario_BD = "sa"
        clave_BD = "jhordan123"
        crear_DB = "crear_DB.sql"
        crear_tabla = "crear_tabla.sql"
        insertar_datos ="insertar_datos.sql"
    }

    stages {
        stage('crear_base_datos') {
            steps {
                script {
                    bat "sqlcmd -S ${nombre_servidor} -U ${usuario_BD} -P ${clave_BD} -d master -f 65001 -i ${crear_DB}"
                }
            }
        }

        stage('crear_tabla') {
            steps {
                script {
                    bat "sqlcmd -S ${nombre_servidor} -U ${usuario_BD} -P ${clave_BD} -d master -f 65001 -i ${crear_tabla}"
                }
            }
        }

        stage('insertar_datos') {
            steps {
                script {
                    bat "sqlcmd -S ${nombre_servidor} -U ${usuario_BD} -P ${clave_BD} -d master -f 65001 -i ${insertar_datos}"
                }
            }
        }
    }
}
