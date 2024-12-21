# Étape 1 : Utiliser une image de base légère avec Java JDK 17
FROM openjdk:17-jdk-slim

# Étape 2 : Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Étape 3 : Copier le fichier JAR généré par Maven dans l'image Docker
# Jenkins génère ce fichier dans le répertoire target après 'mvn clean install'
COPY target/*.jar app.jar

# Étape 4 : Spécifier la commande de démarrage pour l'application
ENTRYPOINT ["java", "-jar", "app.jar"]

# Étape 5 : Exposer le port utilisé par ton application
EXPOSE 8080
