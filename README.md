This is a demo program to show how Feature toggle can be done using Spring Framework in Cloudfoundry.

To compile:
mvn clean package spring-boot:repackage

To push to cloudfoundry:

cf push -f manifest-dev.yml

OR

cf push -f manifest-prod.yml

