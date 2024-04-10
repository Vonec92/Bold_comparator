# Specify the base image to use
FROM node:16.17.1-alpine as build-stage

# Set the working directory to /app
WORKDIR /app

# Copy package.json and package-lock.json to the working directory
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the application code to the working directory
COPY . .

# Build the application
RUN npm run build --omit=dev

# Expose port 81
EXPOSE 81

FROM nginx:1.21.1-alpine
COPY --from=build-stage /app/dist/bbrecommender-fe /usr/share/nginx/html

# Copy the Nginx configuration file to the container
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]






# run front-end server
    # docker build -t bbrfe .
    #docker run --name=frontend -p 4200:4200 bbrfe

#run front-end in bash (dev mode)
    # docker run --name=frontend -it bbrfe /bin/sh
    #ng server --host 0.0.0.0

