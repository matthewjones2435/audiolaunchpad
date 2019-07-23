# Haiku[GA]


* [User stories](docs/user-stories.md)
* [Wireframes](docs/wireframes.md)
* [Data Entities](docs/haiku_ga_erd.png)
* [Milestones](docs/milestones.md)
* [License](LICENSE)
* [Documentation](docs/api/index.html)

Current working state of application, is not working as intended, currently I am unable to call to and recieve a response from the API webservice, also many of the classes within the application are not working with data being passed to eachother and are built using very basic skeletal representations of the classes with "testing" variables being used.  


Haiku [GA] is a generative music tool, aimed to produce procedurally generated music using text
as a seed.  The application will allow the user to enter zero to two keywords and build
a nonsensicle haiku, using the user input the random word function from the Words API.  Once the haiku
 has been built it will be displayed  and analyzed, the data extracted from the haiku will serve as the seed for the generated music.

The generated pieces of music, will be exprotable as a midi file, so that if they are to 
be found interesting by the user they can then export the file and be able to use/edit it in 
any midi compatible piece of software or hardware.  

## Possible Users 
* The aim of the application is to serve as an inspirational spring board for musicians whom have hit creative 
writers block.  
* Casual users who would like to have fun with an application that can produce unique results from simple
user input. 

## Data for Consumption
The planned external service to obtain the genetic sequencing data for the application
to use as a basis for its generative nature will the Words API.  

## Navigtion Method 

The navigation method I would like to use for this application would be a bottom button navigation

#### Activity Elements

* Keyword activity  
     * Where user can input keywords, and produce a random and nonsensical hiaku, the activity 
      will also store entered keywords into a database, so that users can reuse the keywords they have 
      entered in new combonations.  
* Haiku activity 
     * This will be where the generated haiku will be displayed, and also this is where the generated music 
     will take place.  There will be a save haiku option on this page that will create a file, and send 
     for storage.
* Storage Locker activity
     * Here will be the storage of the material that the user has tagged, they will also be able 
     to play, export on this activity as well, the user will also be able to remove the stored 
     material to free storage for new results when the arise.  
     
