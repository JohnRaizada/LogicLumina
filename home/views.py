from django.shortcuts import render
from django.http import HttpResponse
# Create your views here.
def HomePage(request):
    return HttpResponse("<font color=\"red\"><h1>You are at homepage. Alas, I love you.</h1></font>")
def HomePageVersion2(request):
    return HttpResponse("<font color=\"blue\"><h6>You are at homepage. Sadly, I love you.</h6></font>")
