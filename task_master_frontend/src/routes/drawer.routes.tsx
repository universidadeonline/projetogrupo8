import {
  createDrawerNavigator,
  DrawerNavigationProp,
} from "@react-navigation/drawer";

import { Matter } from "../screens/Matter";
import { HomeScreen } from "../screens/HomeScreen";
import { Reports } from "../screens/Reports";
import { Student } from "../screens/Student";
import { CustomDrawerContent } from "../components/CustomDrawerContent";

export type DrawerParamList = {
  HomeScreen: undefined;
  Matter: undefined;
  Reports: undefined;
  Student: undefined;
};

export type DrawerNavigation = DrawerNavigationProp<DrawerParamList>;

export type StackNavigationProps = {
  navigation: DrawerNavigation;
};

const Drawer = createDrawerNavigator<DrawerParamList>();

export function DrawerRoutes() {
  return (
    <Drawer.Navigator
      initialRouteName="HomeScreen"
      screenOptions={{
        headerShown: false,
        drawerStyle: {
          backgroundColor: "#ddd",
        },
      }}
      drawerContent={(props) => <CustomDrawerContent {...props} />}
    >
      <Drawer.Screen
        name="HomeScreen"
        options={{ title: "Início" }}
        component={HomeScreen}
      />
      <Drawer.Screen
        name="Student"
        options={{ title: "Aluno" }}
        component={Student}
      />
      <Drawer.Screen
        name="Matter"
        options={{ title: "Matéria" }}
        component={Matter}
      />
      <Drawer.Screen
        name="Reports"
        options={{ title: "Relatório" }}
        component={Reports}
      />
    </Drawer.Navigator>
  );
}
