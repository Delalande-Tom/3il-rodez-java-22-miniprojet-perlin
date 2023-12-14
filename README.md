<h1>Bruit de perlin</h1>
<p>Le bruit de perlin est une fonction mathématique qui permet de générer des images aléatoires. Il est utilisé dans les jeux vidéos pour générer des terrains aléatoires. Il est aussi utilisé dans les films pour générer des textures.</p>

<h2> Question du sujet </h2>
<h4>Q1.pourquoi l'attribut graine est-il en final ?</h4>
<p>L'attribut graine est en final car une fois que la graine à été défini il ne faut pas qu'elle puisse être modifier</p>

<h4>Q2. Réaliser l'architecture que prendrait la forme d'une telle modélisation sous forme d'un diagramme UML. Quelle serait la différence d'attributs et de méthodes entre ces classes ? Expliquer, en s'appuyant sur un exercice vu en cours, pourquoi c'est une mauvaise idée. Quelle est la solution qu'il faudrait préférer (et que l'on va préférer) ?</h4>
<img src="data/ReadMe/UML.png">
Il n'y aurait aucune différence d'attributs
<p>C'est une très mauvaise idée d'utiliser cette modélisation,en effet elle ne respecte pas les principe ouvert/fermer 
et rend la maintenance difficile. Le mieux serait d'utiliser un pattern visiteur .</p>

<h4>Q3. quel type utilisez-vous ?</h4>
<p>
Les différents type des variables sont :
</p>
    <ul>
        <li>Hydrométrie :  Double </li>
        <li>Température : Double </li>
        <li>Altitude : Double </li>
    </ul> 
<p>J'ai choisi de les mettre en double car il faut pouvoir avoir des valeurs décimales double précision. </p>


<h4>Q4. Pourquoi sortir, selon vous, ce bout d'algorithme de la classe ?</h4>
<p>Selon moi il faut sortir ce bout d'algorythme car pour chaque ajout de nouveau type de terrain il faudrait modifier le code et donc potentiellement introduire une erreur dans un code qui de base fonctionne bien </p>

