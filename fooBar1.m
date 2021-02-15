clear all

x = 12;
x = 15324;

y = x;
output = [];

while y ~= 0
    
    y = floor(sqrt(x));
    x = x - y^2;
    
    if y ~= 0
        output(end+1) = y^2;
    end
end

output