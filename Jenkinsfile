pipeline {
    agent any

    stages {
        // Parar los servicios que ya existen o en todo caso hacer caso omiso
        stage('Parando los servicios...') {
            steps {
                bat '''
                    docker compose -p adj-demo down
                '''
            }
        }

        // Eliminar las imagenes creadas por ese proyecto
        stage('Eliminando imágenes ateriores...') {
            steps {
                bat '''
                    for /f "delims=" %%i in ('docker images --filter "label=com.docker.compose.project=adj-demo" -q') do set IMAGES=%%i
                    if not "%IMAGES%"=="" (
                        docker rmi -f %IMAGES%
                    ) else (
                        echo No hay imagenes por eliminar
                    )
                '''
            }
        }

        // Del recurso SCM configurado en el job, jala el repo
        stage('Obteniendo actualización...') {
            steps {
                checkout scm
            }
        }

        // Construir y levantar los servicios
        stage('Construyendo y desplegando servicios...') {
            steps {
                bat '''
                    docker compose up --build -d
                '''
            }
        }
    }

    post {
        success {
            echo 'Pipeline ejecutado con éxito'
        }

        failure {
            echo 'Hubo un error al ejecutar el pipeline'
        }

        always {
            echo 'Pipeline finalizado uwu'
        }
    }
}