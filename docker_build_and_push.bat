@echo off

echo note that the current images are getting deleted from dockerdesktop
echo do you still want to continue?
set /p userInput="Enter X to stop or any other key to continue: "

if /I "%userInput%"=="X" (
    echo Script stopped by user.
    pause
    exit /b 0
)

set /p name="Enter dockerhub name: "

echo Deleting old images...
docker rmi %name%/beboldrecommender:frontend
docker rmi %name%/beboldrecommender:backend

echo Building frontend image...
cd BBRecommenderFE/
docker build -t %name%/beboldrecommender:frontend .
cd ..

echo Building backend image...
cd BBRecommenderBE/
call mvnw clean package || goto :errors
docker build -t %name%/beboldrecommender:backend .
cd ..

echo Logging in to Docker...
docker login

echo Pushing images to Docker Hub...
docker push %name%/beboldrecommender:frontend
docker push %name%/beboldrecommender:backend

echo Images built and pushed successfully.
pause
exit /b 0

:error
echo Failed to build backend image.
pause
exit /b 1
