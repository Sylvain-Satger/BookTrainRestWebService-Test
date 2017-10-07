Feature: reserver train

Background: 
   Utilisateur recherchant des trains 
   Given Il y a des trains reliant Lyon a Avignon disponibles

#Recherche train allant de Lyon à Avignon 
Scenario: 
   When Je recherche les trains au depart de Lyon,
   And allant a Avignon.
   Then Je recois une liste de trains.
   
   When Je valide une reservation pour 2 personnes sur le train de 12h50,
   And que je fais une recherche sur ma reservation
   Then Je visualise ma reservation.
