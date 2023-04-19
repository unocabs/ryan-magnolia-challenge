# Expectations #

* When you are finished with the challenge, send us a link of your forked Bitbucket repository.
* You must take this challenge on your own and **not** as a team.
* The work you submit best represents your programming knowledge and code organizational skills.
* You should be prepared to walk us through your work via an in-person interview or screen share.
* Feel free to reach out to us if you have any specific questions or have any problems.

# Local environment setup #

The below instructions will aid in the setup of a fresh magnolia development environment on your machine. This project provides you with a magnolia community maven based webapp project (crescendo-magnolia-challenge-webapp), a blossom module which is a magnolia + spring framework integration module (crescendo-magnolia-challenge-core), and a light module w/ all the necessary frontend apps/templates/areas/components.

### Software pre-requisites ###

Download and install the required software below.

* Java JDK 1.8
* Maven 3.2.3 or later
* Mercurial
* Tomcat 8.0
* IntelliJ IDEA Ultimate

### Project setup instructions ###

1. Download & install above software pre-requisites.
2. [Fork the project](https://confluence.atlassian.com/bitbucket/forking-a-repository-221449527.html) into your own bitbucket account.
3. Follow [Maven setup](https://wiki.magnolia-cms.com/display/DEV/Maven+setup) documentation. Follow community edition specific instructions only.
4. Clone project into your desired location on your machine.
5. From command line: run `mvn clean install` in the root of the project. If you never used maven before, this may take 5-10 minutes to download all dependencies and result in `BUILD SUCCESS`.
6. Switch to IntelliJ.
7. Close all open projects, click `Import Project`.
8. Choose `Import project from external model` and select `Maven`.
9. Keep clicking `Next` until you select SDK. Make sure you add/select the Java 1.8 JDK. Click `Next`.
10. Leave project name defaults and click `Finish.`
11. Click little down arrow on upper right hand corner (Select Run/Debug Configuration). Click `Edit Configurations`.
12. Click `+`, Scroll down to `Tomcat Server`, Select `Local`.
13. Name it `Tomcat 8.0` (you can name it whatever you want).
14. Under `Server` tab, Configure the `Application server` to be your new Tomcat v8.0.
15. Under `Server` tab, Put `-Xmx1024m` into the `VM Options` input.
16. Under `Deployment` tab, click `+`, select `Artifact`, and choose the exploded war.
17. Under `Deployment` tab, change `Application context` to `/local`.
18. Click `Apply`.
19. Under `Server` tab, change `On 'Update' action` and `On frame deactivation` to `Update classes and resources`.
20. Click `Apply` and `OK`.
21. Copy `magnolia.properties.example` under `crescendo-magnolia-challenge-webapp/src/main/webapp/WEB-INF/config/local` and rename to `magnolia.properties`.
22. Modify `magnolia.home` property for your case. This is the absolute path where Magnolia will store all data for Derby which is a flat file database. We recommend storing your repositories all in a similar place, i.e. `<USER ROOT>/repositories/<PROJECT NAME>`
23. Modify `magnolia.resources.dir` property for your case. This is just an absolute path to the light-modules folder in your project.
24. Say a prayer
25. Start Tomcat
26. You should be able to go to [http://localhost:8080/local](http://localhost:8080/local).
27. Login as `superuser` with the password `superuser`.
28. Enjoy!

# Challenge #1 :: Saving form data to the JCR #

Say you were tasked with taking an already provided sweepstakes entry form and you needed to save the form data to the sweepstakes JCR repository. This is a test of your form processing skills by serving up a form on the GET method, and handling the POST request to save the data.

### Tasks to accomplish ###

* On GET show the provided sweepstakes form.
* On POST save the form data to the JCR and respond with a thank you message.
* Provide backend validation making sure all text fields have a value and the e-mail address is formatted as email@company.com.
* Test your work by visiting the **Sweepstakes content app** which is available in the app launcher.

### Helpers ###

* We already provided you with the sweepstakes content app, page template, YAML based component (with model class), and blossom based component. It's up to you as a developer to go the modelClass or blossom route. You just need to create the sweepstakes page and add whichever component you choose to finish developing.
* You can see the YAML content app, page, component, and dialog definitions provided under /light-modules/crescendo-magnolia-challenge.
* To learn more about model classes. See the [documentation here.](https://documentation.magnolia-cms.com/display/DOCS56/Model)
* To learn more about blossom based components. See the [documentation here.](https://documentation.magnolia-cms.com/display/DOCS56/Blossom+module#Blossommodule-Components)
* See the [JCR API documentation](https://documentation.magnolia-cms.com/display/DOCS/JCR+API) for help on saving data to the JCR.
* The workspace you'll be saving to is **sweepstakes**.
* The node type you'll be creating is **mgnl:sweepstakes-entry**.

# Challenge #2 :: Load recipe data, save to JCR, and output recipe JCR data as JSON #

Say you were tasked with the migration of content from a legacy system into the Magnolia CMS. The way the migration should work is to read from an endpoint that contains JSON, save the information to the recipes repository, and provide access via a newly built API endpoint. The overall goal of this challenge is for you to show how you would import this data into Magnolia and provide the new API endpoint to output the data from the recipes repository.

### Tasks to accomplish ###

* Finish writing the **LoadRecipesCommand** by reading data from `http://www.johnsonville.com/recipes.top-rated.json` and saving the data to the JCR.
* To keep things simple just save the title, description, prepTime, cookTime, and servingSize fields to the JCR.
* Finish writing the **RecipesController** by querying the JCR for all recipes and outputting the data as JSON.

### Helpers ###

* The **LoadRecipesCommand** is triggered by clicking the provided *Load data* action in the Recipes content app.
* The **LoadRecipesCommand** is located at **crescendo-magnolia-challenge-core/src/main/java/com/crescendocollective/commands/LoadRecipesCommand.java**
* See the [JCR API documentation](https://documentation.magnolia-cms.com/display/DOCS/JCR+API) for help on saving data to the JCR.
* The **RecipesController** is located at **crescendo-magnolia-challenge-core/src/main/java/com/crescendocollective/web/api/RecipesController.java**
* The URL for the provided API endpoint will be [http://localhost:8080/local/api/recipes](http://localhost:8080/local/api/recipes).
* See the [JCR Query Utility documentation](https://bitbucket.org/trillitech/crescendo-module-essentials/src/7405a90b54e27ec6a0e73887f82d93319577876a/?at=v1.5.2) for help on querying the JCR. This is one of several ways of pulling data from the JCR.
* The workspace you'll be saving to is **recipes**.
* The node type you'll be creating is **mgnl:recipe**.
