from django.shortcuts import render
from .models import Task
from rest_framework import viewsets
from .serializers import TaskSerializer
from django.utils.decorators import method_decorator
from django.views.decorators.csrf import csrf_exempt

@method_decorator(csrf_exempt, name='dispatch')
class TaskViewSet(viewsets.ModelViewSet):
    queryset = Task.objects.all()  #We use Filters for Ordering so remove order_by part
    serializer_class = TaskSerializer
    
ordering = ('-date_created',)