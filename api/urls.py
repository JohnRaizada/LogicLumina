from django.urls import path, include
from .views import ProcessRequest
urlpatterns = [
    path("", ProcessRequest)
]
