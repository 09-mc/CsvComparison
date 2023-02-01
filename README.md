# CsvComparison
I created this program for a way to compare two different CSV lists. The first list is a list of emails that we currently send reports to. The second list is a list of people who have signed up to our SaaS platform. The goal is to see who is getting the reports but is not signed up to the platform and was requested by a member of our product team internally.


It is important to note that the first list is the basis of what the output is i.e. we are returning some variation of the first list. Any names that are common in list 1 & 2 are removed from list 1 which is then output to a CSV.


Using buffered reader, we can take in two CSV files and put them into arraylists. Originally, I compared the email addresses from both lists but I found that some users had one email for the reports and another for the platform log in.


To get around this, I compared the name component of the email i.e. john.smith from john.smith@abc.ie. This removed a lot of people that were on both lists but not with the same email address. Just to note that with larger lists this might not work as there may be multiple john.smith's from different organisations but in this case, it worked out fine.


Using a lambda, I compared the name component for each user in the emailContent list to names in the firstContent list. If they were found to be on both, I added their full email to the outputContent list.


I then used the class CsvWriter to write the results of the outputContent to a CSV file.
