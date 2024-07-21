# Import pandas
import pandas
import sys
sys.path.append("C:/Users/SULBHAPAWDE/AppData/Local/Programs/Python/Python312/Lib/site-packages/")

# Read data from Excel sheet
dataframe = pandas.read_excel('sample.xlsx')

# Print the dataframe
print(dataframe)

# Print the number of rows and columns
print("====================================")
print("Number of rows and columns:", dataframe.shape)

# Print the data in the emails column only
print("====================================")
print("Emails:")
print(dataframe['Email'])

# Sort the data based on FirstName in ascending order and print the data
print("====================================")
print("Sorted data:")
print(dataframe.sort_values('FirstName'))