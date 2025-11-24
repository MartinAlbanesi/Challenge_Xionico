from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
from .models import Task
from .serializers import TaskSerializer

class TaskListCreateView(APIView):

    def get(self, request):
        tasks = Task.objects.all()
        serializer = TaskSerializer(tasks, many=True)
        return Response(serializer.data)

    def post(self, request):
        serializer = TaskSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

## @csrf_exempt
## def task_api(request,id=0):
##    if request.method == 'GET':
##        tasks = Task.objects.all()
##        tasks_serializer = TaskSerializer(tasks, many=True)
##        return JsonResponse(tasks_serializer.data, safe=False)
##    elif request.method == 'POST':
##        task_data = JSONParser().parse(request)
##        task_serializer = TaskSerializer(data=task_data)
##        if task_serializer.is_valid():
##            task_serializer.save()
##            return JsonResponse("Added Successfully", safe=False)
##        return JsonResponse("Failed to add", safe=False)