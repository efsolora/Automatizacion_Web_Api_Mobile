pipeline {
    agent any
    stages {
        stage('Clonar repositorio') { // Etapa para clonar el repositorio
            steps {
                git credentialsId: '7890', url: 'https://github.com/Jamesmb06/RetoAutomatizacionChoucair.git'
            }
        }
    stage('Build') { // Etapa para construir 
      steps {
        dir('AutomatizacionWebExito') {
          bat 'gradle clean build'
        }
      }
    }
    
    stage('Test') { // Etapa para ejecutar las pruebas
      steps {
        dir('AutomatizacionWebExito') {
          bat 'gradle test'
        }
      }
    }
    
