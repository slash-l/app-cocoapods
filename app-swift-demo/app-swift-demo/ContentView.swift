//
//  ContentView.swift
//  demo-app
//
//  Created by Jing Yi Liu on 2022/3/4.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack {
            VStack {
                VStack {
                    Text("Hello JFrog")
                        .font(.largeTitle)
                        .fontWeight(.black)
                        .foregroundColor(Color.green)
                        .padding()
                        
                    ColorPicker("This is a simple swift app. Let's do it!", selection: /*@START_MENU_TOKEN@*/.constant(.red)/*@END_MENU_TOKEN@*/)
                        .padding(.leading, 16.0)
                }
                HStack {
                    DatePicker(selection: /*@START_MENU_TOKEN@*/.constant(Date())/*@END_MENU_TOKEN@*/, label: { Text("Date") })
                    
                    Button("确认 ") {
                        /*@START_MENU_TOKEN@*//*@PLACEHOLDER=Action@*/ /*@END_MENU_TOKEN@*/
                    }
                    
                }
            }
            
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
