# Étape de construction
FROM node:18 AS build

WORKDIR /app

# Copier les fichiers package.json et package-lock.json ou yarn.lock
COPY package*.json ./
COPY yarn.lock ./

# Installer les dépendances
RUN yarn install

# Copier le reste des fichiers du projet
COPY . .

# Construire l'application avec Vite
RUN yarn build

# Étape de production
FROM node:18
WORKDIR /app  COPY --from=build /app/dist /app/dist

# Ajouter un simple serveur express pour servir les fichiers statiques
RUN npm install express@4.20.0

# Créer un fichier server.js pour servir les fichiers construits
RUN echo "const express = require('express'); const path = require('path'); const app = express(); app.use(express.static(path.join(__dirname, 'dist'))); app.get('*', (req, res) => { res.sendFile(path.join(__dirname, 'dist', 'index.html')); }); app.listen(3000, () => { console.log('Server is running on port 3000'); });" > server.js

# Exposer le port 3000
EXPOSE 3000
CMD ["node", "server.js"]
