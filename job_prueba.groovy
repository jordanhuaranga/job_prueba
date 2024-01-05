pipeline{
    agent any
    
    environment {
    
    nombre_servidor = "DESKTOP-8ONKPR4"
    usuario_BD = "sa"
    clave_BD = "jhordan123"
    
    }
        stages{

            stage('crear_base_datos'){
                steps{
                    script{
                        bat "sqlcmd -S ${nombre_servidor} -U ${usuario_BD} -P ${clave_BD} -d master -f 65001 -i CREATE DATABASE PRUEBA1;"
                    }
                    
                }
            }
            stage('crear_tabla'){
                steps{
                    script{
                        
                        bat "sqlcmd -S ${nombre_servidor} -U ${usuario_BD} -P ${clave_BD} -d master -f 65001 -i CREATE TABLE tabla_jordan (id int PRIMARY KEY, nombre VARCHAR(100), edad int);"}
                    
            }
            stage('insertar_datos'){
                steps{
                    script{
                        bat "sqlcmd -S ${nombre_servidor} -U ${usuario_BD} -P ${clave_BD} -d master -f 65001 -i INSERT INTO tabla_jordan (id, nombre, edad) VALUES (2, 'Scottie Pippen', 56), (3, 'Dennis Rodman', 60), (4, 'Toni Kukoc', 53);"}
                    }
                    }
            }
        }

}