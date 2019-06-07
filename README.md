# Digital Audio Launchpad


* [User stories](docs/user-stories.md)
* [Wireframes](docs/wireframes.md)

Digital Audio Launchpad is a generative music tool, aimed to produce beats, loops, and aural
drones based upon data mined from genetic sequencing data.  The application will allow the to search
common names of  vertebrate animals , use the search to return the genetic sequence of the of the query.
Once the sequence has been found the string information will then be used 
as the basis for the data in which the application's algorithms construct its 
finished product.  

The generated pieces of music, will be exprotable as a midi file, so that if they are to 
be found interesting by the user they can then export the file and be able to use it in 
any midi compatible (which only very few things are not midi compatible) piece of software or 
hardware.  

The User will be able to perform a new search at any time by navigating to the correct activity,and 
be able to store preferred searches if they have found that the generative results from particular 
searches have been interesting to them.  The user will also have a storage locker of 
beats, loops, or drones, this storage locker can be used to save the tagged material that the 
user has generated.

## Possible Users 
* The aim of the application is to serve as a spring board for musicians whom have hit creative 
writers block.  
* Casual users who would like to have fun with an application that can produce unique results from 
basic searches 

## Data for Consumption
The planned external service to obtain the genetic sequencing data for the application
to use as a basis for its generative nature will the Ensembl api.  

## Navigtion Method 

The navigation method I would like to use for this application would be a bottom button navigation.
I believe it will add an element of ease of use for the application.  

#### Activity Elements

* Search activity  
     * Where user can input searches, save past searches to generate new material from
* Generate activity 
     * User will be able to define some basic elements of the end generative result such as 
      type of musical material, beat/bar length, number of variations that will be produced.
* Results activity 
     * This will display the results of the application and variations of the materail that was computed 
     here the user will be able to play the results, export as midi for futher experimentation, and 
     the user will be able to tag the results they would like to save for later.
* Storage Locker activity
     * Here will be the storage of the material that the user has tagged, they will also be able 
     to play, export on this activity as well, the user will also be able to remove the stored 
     material to free storage for new results when the arise.  
     