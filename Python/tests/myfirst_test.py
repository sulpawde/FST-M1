import sys
sys.path.append("C:/Users/SULBHAPAWDE/AppData/Local/Programs/Python/Python312/Lib/site-packages/")
import pytest
import math

def test_sqrt():
   num = 25
   assert math.sqrt(num) == 5

def testsquare():
   num = 7
   assert num*num == 49

def tesequality():
   assert 10 == 11