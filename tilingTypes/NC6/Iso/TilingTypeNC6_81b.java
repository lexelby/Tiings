package tilingTypes.NC6.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_81b
   extends TilingType
{
   public TilingTypeNC6_81b(){
      super( "NC6-81b", 6, SymmetryType.pmg );

      paramMin = new int[]{  0,  0,  0,  0,  0};
      paramMax = new int[]{100,180,100,100,100};
      paramDef = new int[]{ 40, 70, 40, 20, 30};
      paramName = new String[]{"Aspect", "Angle", "Relative Length 2", "X", "Y"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 5,2, 0,2,5, 0},

            {0, 0,1, 0,0,1, 1},
            {0, 5,2, 2,2,5, 1},
      };
      info = "d=f\nA+B=180\nD+E=360\n(C+F=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 2.0;
      double ln1 = lntotal * getParam(paramValues,0)/100;
      double ln23 = lntotal-ln1;
      double ln2 = ln23 * getParam(paramValues,2)/100;
      double ln3 = ln23-ln2;

      double a = getParam(paramValues,1);
      double c = Math.cos(a*DEG2RAD);
      double s = Math.sin(a*DEG2RAD);
      
      double x = ln1 * getParam(paramValues,3)/100;
      double y = ln23 * getParam(paramValues,4)/100;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln1,  0);
      baseTile.setPoint(2, ln1 + ln2*c, ln2*s);
      baseTile.setPoint(3, ln1-x+(ln23-y)*c, (ln23-y)*s );
      baseTile.setPoint(4,  x+y*c,  y*s);
      baseTile.setPoint(5,  ln3*c, ln3*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(0)-tiles[3].getX(0);
      offsets[3] = tiles[1].getY(0)-tiles[3].getY(0);
   }
}