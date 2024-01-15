pipeline {
    agent any

    stages {
        stage('Preparación del Proyecto') {
            steps {
                // Agrega los comandos necesarios para preparar el proyecto desde GitHub
                checkout scm // Esto descarga el código fuente desde tu repositorio Git
            }
        }
        stage('Construcción del Proyecto') {
            steps {
                // Agrega los comandos necesarios para construir el proyecto
                bat 'mvn clean install' // Esto ejecuta Maven para construir tu proyecto
            }
        }
        stage('Reporte mediante JUnit') {
            steps {
                // Agrega los comandos necesarios para generar el reporte mediante JUnit
                bat 'mvn test' // Esto ejecuta tus pruebas JUnit
            }
        }
    }
}
