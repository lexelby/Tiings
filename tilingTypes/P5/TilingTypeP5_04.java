package tilingTypes.P5;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP5_04
   extends TilingType
{
   public TilingTypeP5_04(){
      super( "P5-4: Type 1 - Generic", 5, SymmetryType.p2 );

      paramMin = new int[]{-89,  0,   0,-50,-89};
      paramMax = new int[]{ 89,100, 100,500, 89};
      paramDef = new int[]{ 10, 40,  60, 20, 10};
      paramName = new String[]{ "Angle", "Aspect", "Side split", "Point distance", "Point offset"};
      // 0=ori, 1=scale=vertical width,  2=angle of parallel sides, 3=hor/vert ratio, 4=parside split, 5=dist, 6=angle

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,2, 0,2,1, 0},
            };
      info = "B+C=180\n(A+D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln2 = 2*paramValues[1]/100.; //vertical distance of parallel sides
      double w = 2-ln2;
      double t = w*Math.tan( paramValues[0]* DEG2RAD); // offset of the parallellogram sides with triangles
      double ln6 = ln2*Math.tan( paramValues[4]* DEG2RAD); // offset of the point w.r.t. middle of para side
      double ln5 = paramValues[3]/100.; //horizontal distance from middle of parallelogram side to point
      double ln4 = w*paramValues[2]/100.; //side split

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln4, ln4*t);
      baseTile.setPoint(2, w-ln4, ln2 + t*(w-ln4));
      baseTile.setPoint(3, 0, ln2 );
      baseTile.setPoint(4, -ln5, ln2/2-ln6);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(4)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(4)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(3)-tiles[0].getY(0);
   }
}
