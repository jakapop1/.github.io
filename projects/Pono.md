---
layout: project
type: project
image: img/4k1.jpg  
title: "HACC 2023"
date: 2023
published: true
labels:
  - Javascript
  - GitHub
  - HTML
  - CSS
  - Web-Development
summary: "ICS314/HACC project"
---

<!-- Brief project summary -->
HACC-2023 project with the goal of creating a web application for the people of Hawaii to find medical care regardless of insurance status. 

## Introduction

Getting medical coverage can be tricky especially if you are un/under-insured. In some cases, as a result, people seeking medical care end up not going at all as most medical facilities require decent medical coverage. This project aims to help people avoid that situation with the goals of connecting them to a qualified expert that can help.


## Project Overview

What this project aims to do is to provide a web application that stores and filters the locations based off of specific requirements like whether or not a facility requires insurance. Thus, people seeking medical care will be able to find experts in each field of their desired care with the hopes of saving on costs. Around the filter, my team and I have created various pages to fill out the website with things that would provide the user with as much information as possible. 

## Goal of the Project

Create a fully interactive website that allows users to get information on their current medical needs and providing them steps towards assistance. 

## My Role and Contributions

For this project, I worked in a team of 4. My responsibilities were mainly the web-application's backend. My group and I had milestones in which we were to progress in accordingly. My contribution to the project are as follows: 
- Database: Using MongoDB, I set up the user's profiles, medical facilities
- Filter: Created a filter utilizing Javascript to filter in order based off of location, medical service, and insurance status.
- Data-Scraping: Through [health.hawaii.gov](https://health.hawaii.gov/ohca/medicare-facilities/) data was gathered into a js file based off of select information (location, services, insurance etc.) and later retrieval.


## Tools and Technologies
- Programming Language: Java Script, Html, CSS
- Platform: Github
- Testing: TestCafe



## Design & Implementation
- Scraped Data Sample:
```
{
    category: 'Adult Day Health Centers',
    facilities: [
      {
        number: 1,
        facility: 'Ann Pearl Nursing Facility',
        providerBased: 'X',
        freeStanding: '',
        location: 'Oahu',
        address: '45-181 Waikalua Road, Kaneohe, Hawaii 96744',
        phone: '(808) 247-8558',
        fax: '(808) 247-4115',
        administrator: 'Robin Fortin',
      },
      {
        number: 2,
        facility: 'Arcadia Adult Day Care & Day Health Center at Central Union Church',
        providerBased: '',
        freeStanding: 'X',
        location: 'Oahu',
        address: '1660 South Beretania Street, Honolulu, Hawaii 96826',
        phone: '(808) 440-3020',
        fax: '(808) 440-3084',
        chiefOperatingOfficer: 'Stacey Young',
      },  
      
```

- Filter Code 
```
const ListProviders = () => {
  // State hooks for enabling sequential filters
  const [isFacilityTypeEnabled, setIsFacilityTypeEnabled] = useState(false);
  const [isIslandEnabled, setIsIslandEnabled] = useState(false);

  // State hooks for selected options and filters
  const [serviceType, setServiceType] = useState('');
  const [facilityType, setFacilityType] = useState('');
  const [island, setIsland] = useState('');

  // Reset filters and refresh the page
  const resetFilters = () => {
    window.location.reload();
  };

  // Filtering logic based on selected filters
  const filteredFacilities = healthcareFacilities
    .filter(category => serviceType === '' || category.category.toLowerCase() === serviceType.toLowerCase())
    .flatMap(category => category.facilities)
    .filter(facility => (facilityType === '' ||
        (facilityType === 'Free-Standing' && facility.freeStanding.toLowerCase() === 'x') ||
        (facilityType === 'Provider-Based' && facility.providerBased.toLowerCase() === 'x')) &&
      (island === '' || facility.location.toLowerCase() === island.toLowerCase())); 
```
- Database Example:
```
import { Mongo } from 'meteor/mongo';
import SimpleSchema from 'simpl-schema';

class FavoriteUserCollection {
  constructor() {
    /** Define a Mongo collection to hold the user data. */
    this.name = 'FavoriteUserCollection';
    this.collection = new Mongo.Collection(this.name);

    /** Define a schema to specify the structure of each document in the collection. */
    this.schema = new SimpleSchema({
      name: {
        type: String,
        label: 'Favorite Name',
      },
      address: {
        type: String,
        label: 'Address',
```

## Application
<div style="text-align: center;">
<p>Upon site arrival, users are met at the landing page providing an introduction of the site. Users are able to directly go to the filter page. </p>
    <div>
        <img src="/img/pono/1.PNG" alt="Fishing Game" style="max-width: 600px; display: inline-block; margin: 10px;" />
        <img src="/img/pono/2.PNG" alt="Fishing Game" style="max-width: 600px; display: inline-block; margin: 10px;" />
    </div>
    <div>
        <img src="/img/pono/3.PNG" alt="Fishing Game" style="max-width: 600px; display: inline-block; margin: 10px;" />
        <img src="/img/pono/4.PNG" alt="Fishing Game" style="max-width: 600px; display: inline-block; margin: 10px;" />
    </div>
    <div>
        <img src="/img/pono/5.PNG" alt="Fishing Game" style="max-width: 600px; display: inline-block; margin: 10px;" />
        <img src="/img/pono/6.PNG" alt="Fishing Game" style="max-width: 600px; display: inline-block; margin: 10px;" />
    </div>
    <div>
        <img src="/img/pono/7.PNG" alt="Fishing Game" style="max-width: 600px; display: inline-block; margin: 10px;" />
        <img src="/img/pono/8.PNG" alt="Fishing Game" style="max-width: 600px; display: inline-block; margin: 10px;" />
    </div>
    <div>
        <img src="/img/pono/9.PNG" alt="Fishing Game" style="max-width: 600px; display: inline-block; margin: 10px;" />
        <img src="/img/pono/10.PNG" alt="Fishing Game" style="max-width: 600px; display: inline-block; margin: 10px;" />
    </div>
    <div>
        <img src="/img/pono/11.PNG" alt="Fishing Game" style="max-width: 600px; display: inline-block; margin: 10px;" />
        <img src="/img/pono/12.PNG" alt="Fishing Game" style="max-width: 600px; display: inline-block; margin: 10px;" />
    </div>
    <div>
        <img src="/img/pono/13.PNG" alt="Fishing Game" style="max-width: 600px; display: inline-block; margin: 10px;" />
        <img src="/img/pono/14.PNG" alt="Fishing Game" style="max-width: 600px; display: inline-block; margin: 10px;" />
    </div>
    <div>
        <img src="/img/pono/15.PNG" alt="Fishing Game" style="max-width: 600px; display: inline-block; margin: 10px;" />
        <img src="/img/pono/16.PNG" alt="Fishing Game" style="max-width: 600px; display: inline-block; margin: 10px;" />
    </div>
    <div>
        <img src="/img/pono/17.PNG" alt="Fishing Game" style="max-width: 600px; display: inline-block; margin: 10px;" />
        <img src="/img/pono/18.PNG" alt="Fishing Game" style="max-width: 600px; display: inline-block; margin: 10px;" />
    </div>
</div>>

## Lessons Learned

Through this project, I have gained further insight into collaborative environment and web application building. Requiring many components to be made, this project allowed me to work with others while addressing various issues throughout the developmental process. As a result, we created various parts that worked together to work as a whole. 







## Resources

[Deployed-site](https://ponohealthproviders.com/)
[Github Homepage](https://team-jackfruit.github.io/PonoHealthProviders/)
[readme](https://github.com/team-jackfruit/PonoHealthProviders/blob/main/README.md)
[Repository](https://github.com/team-jackfruit/PonoHealthProviders)


