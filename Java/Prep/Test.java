import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String [] args) {
    	
    	String[] certs = {"Accessibility Advocate","Accessibility Foundations","Adobe Certified Expert - Adobe Analytics Business Practitioner","Advancing Accessibility","Aerospace and Defense Industry Jumpstart","AgileTA Explorer","App Modernization Basics","Associate Cloud Engineer","Automation Specialist for API","Automation Specialist Level 2","Automotive Industry Jumpstart","AWS Certified Cloud Practitioner","AWS Partner: Generative AI Essentials (Business)","AZ-305: Designing Microsoft Azure Infrastructure Solutions","AZ-400: Designing and Implementing Microsoft DevOps Solutions","Banking Industry Jumpstart","Big Data Foundations - Level 1","Blue Core Mentor","Build Your Own Chatbot - Level 1","CCNA: Introduction to Networks","Certified SAFe Practitioner","Certified SAFe® 4 Agilist","Certified SAFe® 4 Practitioner","Certified SAFe® 5 Agilist","Certified SAFe® 5 Practitioner","Certified SAFe® 5 Product Owner/Product Manager","Certified Software Testing Manager","Cloud Core","Cognitive Practitioner","CU™ Certified Cloud Test Practitioner (CTP)","Data Science Foundations - Level 1","Data Science Orientation","Data Science Tools","DevNet Associate","DevSecOps Essentials","Docker Essentials: A Developer Introduction","Energy, Environment and Utilities Industry Jumpstart","Enterprise Design Thinking - Team Essentials for AI","Enterprise Design Thinking Co-Creator","Enterprise Design Thinking for Sustainability","Enterprise Design Thinking Practitioner","Explorations into Mindfulness","Hadoop Administration - Level 1","Hadoop Data Access - Level 1","Hadoop Foundations - Level 1","Hadoop Foundations - Level 2","Hadoop Programming - Level 1","Hadoop Programming - Level 2","Healthcare Industry Jumpstart","IAAP Certified Professionals in Accessibility Core Competencies (CPACC)","IBM Agile Advocate","IBM Agile Explorer","IBM AI Associate for All IBMers","IBM AI Associate Product Manager","IBM Automation Practitioner","IBM Automation: Compass","IBM Big SQL V5.0.x Analyze Data","IBM Blockchain Essentials","IBM Blockchain Essentials V2","IBM Blockchain Foundation Developer","IBM Certified Advocate - Cloud v1","IBM CLM® for SAFe® - Level 1","IBM Cloud Essentials","IBM Cloud Migration and Modernization Method Explorer 2","IBM Consulting – Building Teams","IBM Consulting – Communicating Value","IBM Consulting – Delivering Business Value","IBM Consulting – Delivering Trust","IBM Consulting – Leading Initiatives","IBM Consulting Way","IBM DevSecOps Explorer - Security & Automation for DevOps","IBM Explorer Project Manager","IBM Garage Essentials","IBM Garage Foundation","IBM Garage Methodology Explorer","IBM Growth Behaviors","IBM IGNITE - Application IMPACT Methods","IBM IGNITE - Membership","IBM IGNITE - Mobile / Digital Testing","IBM IGNITE - Quality Engineering","IBM IGNITE - Quality Engineering Solution Delivery","IBM IGNITE - Technical Test Delivery","IBM IGNITE - Test Automation Solution Development","IBM IGNITE - Test Design & Modeling","IBM IGNITE - Test Design & Modeling Coach","IBM Machine Learning Essentials","IBM Quality Engineering Foundations","IBM Quantum Conversations","IBM Virtual Collaborator","IBM Z Secure Engineering - Knight-Errant","Interskill - Blockchain Foundations","IoT - Engineering - LL - Intro to IBM Engineering Test Management","ISTQB Certified Tester - Foundation Level","ISTQB Foundation Level","IT Academy: Network Virtualization Concepts","IT Academy: Software Defined Storage Concepts","Knowledge Sharing for Business Impact","Machine Learning with Python - Level 1","Method Essentials","Microsoft Certified: Azure Administrator Associate","Microsoft Certified: Azure AI Fundamentals","Microsoft Certified: Azure Data Fundamentals","Microsoft Certified: Azure Fundamentals","Microsoft Certified: Azure Solutions Architect Expert","Microsoft Certified: DevOps Engineer Expert","Power Skills - Communication, Presentation, Collaboration, and Problem Solving","Professional Cloud Architect","Professional Member","Professional Scrum Master I Assessment","Python for Data Science","Python for Data Science and AI","Security and Privacy by Design Foundations","Siebel 8 Consultant Certified Expert","Simplifying Data Pipelines with Apache Kafka","Telecommunications Industry Jumpstart","Telecommunications Insights and Solutions (Bronze)","Telecommunications Insights and Solutions (Silver)","The IBM Way","Think Like a Hacker","Trustworthy AI and AI Ethics","Watson and Cloud Foundations","Watson Speech to Text","Data Analysis Using Python"};
    
    	
    	/**
    	 * Agile - Keywords
    	 * SAF
    	 * Agile
    	 * */
    	
    	/**
    	 * Cloud
    	 * AWS
    	 * Az
    	 * */
    	/*
    	 * 
    	 * Pattern cloudPattern = Pattern.compile(".*Cloud.*|.*AWS.*|.*Azure.*|.*AZ.*|.*Redhat.*|.*GCP.*|.*Openshift.*", Pattern.CASE_INSENSITIVE);
    	Pattern agilePattern = Pattern.compile(".*Agile.*|.*SAF.*|.*Scrum.*|.*CSM.*|.*Product owner.*", Pattern.CASE_INSENSITIVE);
    	Pattern industryPattern = Pattern.compile(".*Industry.*|.*Jumpstart.*|.*Enterprise Design Thinking.*|.*IBM Consulting.*|.*IBM Garage.*|.*IBM Explorer.*|.*IBM Growth.*|.*IBM Quality.*|.*Silver.*|.*Bronze.*|.*Gold.*|.*Platinum.*", Pattern.CASE_INSENSITIVE);
    	Pattern agileCertPattern = Pattern.compile(".*Certified.*|.*Assessment.*", Pattern.CASE_INSENSITIVE);
    	Pattern indusrtyCertPattern = Pattern.compile(".*Industry.*|.*Jumpstart.*|.*Enterprise Design Thinking.*|.*Silver.*|.*Bronze.*|.*Gold.*|.*Platinum.*", Pattern.CASE_INSENSITIVE);
    	
    	 */
    	
    	String cert = "certified agile specialist";
    	
    	if((cert.contains("certified") && cert.contains("agile"))) {
    		System.out.println("Match!");
    	}
    	
    	Pattern cloudPattern = Pattern.compile("(?=.*Cloud.*|.*AWS.*|.*Azure.*|.*AZ.*|.*Redhat.*|.*GCP.*|.*Openshift.*)", Pattern.CASE_INSENSITIVE);
    	Pattern agilePattern = Pattern.compile("(?=.*Agile.*|.*SAF.*|.*Scrum.*|.*CSM.*|.*Product owner.*)", Pattern.CASE_INSENSITIVE);
    	Pattern industryPattern = Pattern.compile("(?=.*IBM Consulting.*|.*IBM Garage.*|.*IBM Explorer.*|.*IBM Growth.*|.*IBM Quality.*|.*Industry.*|.*Jumpstart.*|.*Enterprise Design Thinking.*|.*Silver.*|.*Bronze.*|.*Gold.*|.*Platinum.*)", Pattern.CASE_INSENSITIVE);
    	Pattern agileCertPattern = Pattern.compile("(?=.*Agile.*|.*SAF.*|.*Scrum.*|.*CSM.*|.*Product owner.*)(?=.*Certified.*|.*Assessment.*)", Pattern.CASE_INSENSITIVE);
    	Pattern indusrtyCertPattern = Pattern.compile("(?=.*Industry.*|.*Jumpstart.*|.*Enterprise Design Thinking.*|.*Silver.*|.*Bronze.*|.*Gold.*|.*Platinum.*)", Pattern.CASE_INSENSITIVE);
    	
    	List<String> agileList = new ArrayList<>();
    	List<String> agileCertList = new ArrayList<>();
    	List<String> cloudList = new ArrayList<>();
    	List<String> industryList = new ArrayList<>();
    	List<String> industryCertList = new ArrayList<>();
    	List<String> others = new ArrayList<>();
    	
    	for(int i=0;i<certs.length;i++) {
    		
    		Matcher agileMatcher = agilePattern.matcher(certs[i]);
    		Matcher cloudMatcher = cloudPattern.matcher(certs[i]);
    		Matcher industryMatcher = industryPattern.matcher(certs[i]);
    		Matcher agileCertMatcher = agileCertPattern.matcher(certs[i]);
	    	Matcher industryCertMatcher = indusrtyCertPattern.matcher(certs[i]);
//    		System.out.println(matcher);
    		if(agileMatcher.matches() && agileCertMatcher.matches()) {
    			agileCertList.add(certs[i]);
    		}
    		else if(agileMatcher.matches()) {
    			agileList.add(certs[i]);
    		}
    		else if(cloudMatcher.matches()) {
    			cloudList.add(certs[i]);
    		}
    		else if(industryMatcher.matches() && industryCertMatcher.matches()) {
    			industryCertList.add(certs[i]);
    		}
    		else if(industryMatcher.matches()) {
    			industryList.add(certs[i]);
    		}
    		else {
    			others.add(certs[i]);
    		}
    		
    	}
    
    	System.out.println("Total: " + certs.length);
    	System.out.println("-------------Agile Training-----------------");
    	for(String cert: agileList) {
    		System.out.println(cert);
    	}
    	System.out.println();
    	System.out.println("Number of Agile Trainings: " + agileList.size());
    	System.out.println();
    	
    	
    	System.out.println("-------------Agile Certifications-----------------");
    	for(String cert: agileCertList) {
    		System.out.println(cert);
    	}
    	System.out.println();
    	System.out.println("Number of Agile Certifications: " + agileCertList.size());
    	System.out.println();
    	
    	
    	System.out.println("-------------Cloud Certifications-----------------");
    	for(String cert: cloudList) {
    		System.out.println(cert);
    	}
    	System.out.println();
    	System.out.println("Number of Cloud Certifications: " + cloudList.size());
    	System.out.println();
    	
    	
    	System.out.println("-------------Industry Trainings-----------------");
    	for(String cert: industryList) {
    		System.out.println(cert);
    	}
    	System.out.println();
    	System.out.println("Number of Industry Trainings: " + industryList.size());
    	System.out.println();
    	
    	
    	System.out.println("-------------Industry Badges/Certifications-----------------");
    	for(String cert: industryCertList) {
    		System.out.println(cert);
    	}
    	System.out.println();
    	System.out.println("Number of Industry Certifications: " + industryList.size());
    	System.out.println();
    	
  
    	System.out.println("-------------Other Certifications-----------------");
    	for(String cert: others) {
    		System.out.println(cert);
    	}
    	System.out.println();
    	System.out.println("Number of Other Certifications: " + others.size());
    	
    	
    }
}