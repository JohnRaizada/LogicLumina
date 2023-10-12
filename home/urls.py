from django.urls import path, include
from .views import HomePage, HomePageVersion2
urlpatterns = [
    path('', HomePage),
    path('version2', HomePageVersion2)
]
