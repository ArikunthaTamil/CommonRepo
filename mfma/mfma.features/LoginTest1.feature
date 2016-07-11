@testfeature
Feature: Login to M-Files Mobile App Test1

Scenario Outline: Get the list of vaults available for the user
	When Enter server <server> name
	And Click Connect to enter login credentials
	Given Enter user name <uname> and  <password> password
	And Click Login to see the list of vaults
	And Click on the vault <vault> from the list

Examples:
    | 				server 					| 	uname | 	password | 			vault 		|
    | "http://172.24.166.141" | "alexk" | 		"a"		 | "Sample Vault" |
    | "http://172.24.166.141" | "miket" | 		"a"		 | "Sample Vault" |