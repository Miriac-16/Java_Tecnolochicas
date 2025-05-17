# test.jl
# A simple Julia script to test basic functionality

# Print a greeting message
println("Hello, Julia!")

# Perform a basic calculation
a = 10
b = 20
println("The sum of $a and $b is $(a + b)")

# Test a loop
println("Testing a loop:")
for i in 1:5
    println("Iteration $i")
end

# Test a function
function greet(name)
    return "Hello, $name!"
end

println(greet("Mirian"))