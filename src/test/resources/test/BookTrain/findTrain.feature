Feature: recherche train

Background: 
   Utilisateur recherchant des trains 
   Given Il y a uniquement des trains reliant Lyon a Avignon

#Recherche train allant de Lyon à Avignon 
Scenario: 
   When Je recherche les trains au depart de Lyon,
   And allant a Avignon.
   Then Je recois une liste de trains.
   
#Recherche train allant de Lyon à Montpellier 
Scenario: 
   When Je recherche les trains au depart de Lyon,
   And allant a Montpellier.
   Then Je recois une liste de trains vide.
