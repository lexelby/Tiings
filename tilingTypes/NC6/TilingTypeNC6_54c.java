package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_54c
   extends TilingType
{
   public TilingTypeNC6_54c(){
      super( "NC6-54c", 9, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0,  0,  0,  0};
      paramMax = new int[]{100,100,180,180,100,100};
      paramDef = new int[]{ 50, 65, 95,120,  0,  0};
      paramName = new String[]{"Aspect", "Relative Length", "Angle 1", "Angle 2", "Offset 1", "Offset 2"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 5,7, 0,1,3, 1},
            {1, 3,2, 1,2,3, 1},
            {0, 1,3, 2,5,7, 0},
            
            {0, 5,6, 0,6,7, 1},
            {1, 5,7, 4,1,3, 0},
            {1, 3,2, 5,2,3, 0},
            {0, 1,3, 6,5,7, 1},
      };
      info = "a=c\nb=e\nd=f\nA+B=180\nC+F=360\n(D+E=180)";
      labels = new int[]{0,-1,-1,1,2,3,-1,4,5};
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 1.0;
      double ln1 = lntotal * getParam(paramValues, 0)/100;
      double ln23 = lntotal - ln1;
      double ln2 = ln23 * getParam(paramValues, 1)/100;
      double ln3 = ln23 - ln2;

      double a = getParam(paramValues, 2);
      double b = getParam(paramValues, 3);
      double os1 = ln1 * getParam(paramValues, 4)/100;
      double os2 = ln1 * getParam(paramValues, 5)/100;
      
      double c1 = ln2 * Math.cos( a * DEG2RAD );
      double s1 = ln2 * Math.sin( a * DEG2RAD );
      double c2 = ln3 * Math.cos( b * DEG2RAD );
      double s2 = ln3 * Math.sin( b * DEG2RAD );

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  os1, 0);
      baseTile.setPoint(2,  os2, 0);
      baseTile.setPoint(3, ln1, 0);
      baseTile.setPoint(4, ln1 + c1, s1);
      baseTile.setPoint(5, ln1+c1+c2, s1+s2);
      baseTile.setPoint(6, ln1/2+c1+c2, s1+s2);
      baseTile.setPoint(7, c1+c2, s1+s2);
      baseTile.setPoint(8, c1, s1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(5)-tiles[7].getX(6);
      offsets[3] = tiles[3].getY(5)-tiles[7].getY(6);
   }
}