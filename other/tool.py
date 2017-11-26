import sys
file_name = sys.argv[1]
out_file = sys.argv[2]
f = open(file_name)
lines = f.read().split("\n")
t = open(out_file, 'w')
for x in range(0, len(lines)-1, 2):
  t.write(lines[x] + " " + lines[x+1] + "\n")
