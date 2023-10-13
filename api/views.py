from django.shortcuts import render
from django.http import HttpResponse, FileResponse
# Create your views here.
def ProcessRequest(request):
    print(request.headers)
    return HttpResponse("Request"+str(request.body))
    file_path = r"C:\Users\indus\Dropbox\PC\Downloads\GLITTER GREEN SCREEN.mp4"
    response = FileResponse(open(file_path, 'rb'))
    response['Content-Type'] = 'video/mp4'
    response['Content-Disposition'] = 'attachment; filename="your_video.mp4"'
    return response
