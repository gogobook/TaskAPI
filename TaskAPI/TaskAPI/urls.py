"""TaskAPI URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/1.10/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  url(r'^$', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  url(r'^$', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.conf.urls import url, include
    2. Add a URL to urlpatterns:  url(r'^blog/', include('blog.urls'))
"""
from django.conf.urls import include, url
from django.contrib import admin
from rest_framework import routers
from django.conf.urls.static import static
from . import settings

from TaskApp import views

#Define API Routes
#router = .... #we will try with SimpleRouter

router = routers.SimpleRouter()

router.register(r'task', views.TaskViewSet)

urlpatterns = [
    url(r'^',include(router.urls)),
    url(r'^admin/', include(admin.site.urls)),
]+static(settings.MEDIA_URL,document_root=settings.MEDIA_ROOT)
