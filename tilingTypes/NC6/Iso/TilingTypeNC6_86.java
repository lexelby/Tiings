package tilingTypes.NC6.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_86
   extends TilingType
{
   public TilingTypeNC6_86(){
      super( "NC6-86", 6, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0,  0};
      paramMax = new int[]{180,100,100,100};
      paramDef = new int[]{ 70, 40, 20, 30};
      paramName = new String[]{"Angle", "Relative Length", "X", "Y"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 5,2, 0,2,5, 0},
            {0, 1,2, 0,0,1, 1},
            {0, 5,2, 2,2,5, 1},
      };
      info = "a+c=b\nd=f\nA+B=180\nD+E=360\n(C+F=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = 1.0;
      double ln2 = ln1 * getParam(paramValues,1)/100;
      double ln3 = ln1-ln2;

      double a = getParam(paramValues,0);
      double c = Math.cos(a*DEG2RAD);
      double s = Math.sin(a*DEG2RAD);
      
      double x = ln1 * getParam(paramValues,2)/100;
      double y = ln1 * getParam(paramValues,3)/100;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln1,  0);
      baseTile.setPoint(2, ln1 + ln2*c, ln2*s);
      baseTile.setPoint(3, ln1-x+(ln1-y)*c, (ln1-y)*s );
      baseTile.setPoint(4,  x+y*c,  y*s);
      baseTile.setPoint(5,  ln3*c, ln3*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(1)-tiles[0].getX(1);
      offsets[1] = tiles[1].getY(1)-tiles[0].getY(1);
      offsets[2] = tiles[1].getX(0)-tiles[0].getX(0);
      offsets[3] = tiles[1].getY(0)-tiles[0].getY(0);
   }
}