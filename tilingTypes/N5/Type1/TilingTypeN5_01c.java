package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01c
   extends TilingType
{
   public TilingTypeN5_01c(){
      super( "N5-1c", 5, SymmetryType.pgg );

      paramMin = new int[]{-89,  0,   0,-50};
      paramMax = new int[]{ 89,100, 100,500};
      paramDef = new int[]{ 10, 40,  60, 20};
      paramName = new String[]{ "Angle", "Aspect", "Side split", "Point distance"};
      // 0=ori, 1=scale=vertical width,  2=angle of parallel sides, 3=hor/vert ratio, 4=parside split, 5=dist

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,2,1, 0},
            {1, 4,3, 1,3,4, 0},
            {0, 1,2, 2,2,1, 0},

            {0, 3,4, 0,4,0, 1},
            {1, 1,2, 4,2,1, 1},
            {1, 4,3, 5,3,4, 1},
            {0, 1,2, 6,2,1, 1},
      };
      info = "a=e\nB+C=180\n(A+D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln2 = 1.5*paramValues[1]/100.; //vertical distance of parallel sides
      double w = 1.5-ln2;
      double t = w*Math.tan( paramValues[0]* DEG2RAD); // offset of the parallellogram sides with triangles
      double ln4 = w*paramValues[2]/100.; //side split
      double ln5 = paramValues[3]/100.; //horizontal distance from middle of parallelogram side to point
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln4, ln4*t);
      baseTile.setPoint(2,w-ln4, ln2 + t*(w-ln4));
      baseTile.setPoint(3,  0, ln2);
      baseTile.setPoint(4, -ln5, ln2/2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(4)-tiles[7].getX(0);
      offsets[1] = tiles[3].getY(4)-tiles[7].getY(0);
      offsets[2] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(3)-tiles[0].getY(0);
   }
}
