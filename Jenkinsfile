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
        dir('AutomatizacionAPI') { // el dir cambia el directorio de trabajo al proyecto de Automatización API
          sh 'gradle clean build' // se ejecuta la tarea de construcción del proyecto
        }
        dir('AutomatizacionWebExito') {
          sh 'gradle clean build'
        }
        dir('RetoExitoMobileChoucair') {
          sh 'gradle clean build'
        }
      }
    }
    
    stage('Test') { // Etapa para ejecutar las pruebas
      steps {
        dir('AutomatizacionAPI') {
          sh 'gradle test'
        }
        dir('AutomatizacionWebExito') {
          sh 'gradle test'
        }
        dir('RetoExitoMobileChoucair') {
          sh 'gradle test'
        }
      }
    }
